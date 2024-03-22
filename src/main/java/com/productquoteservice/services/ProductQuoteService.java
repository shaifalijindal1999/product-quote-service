package com.productquoteservice.services;

import com.productquoteservice.schema.ProductData;
import com.productquoteservice.models.common.ErrorResponse;
import com.productquoteservice.models.common.ProductModels.Product;
import com.productquoteservice.models.response.quote.FailedQuoteResponse;
import com.productquoteservice.models.response.quote.ProductQuoteResponse;
import com.productquoteservice.models.response.quote.QuoteResponse;
import com.productquoteservice.repositories.ProductDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQuoteService {

    @Autowired
    ProductDataRepository productDataRepository;
    public QuoteResponse getProductQuote(String id, int requestedQuantity) {

        // Validate request parameters
        if (id == null || id.isEmpty() || requestedQuantity < 0) {
            return new FailedQuoteResponse(new ErrorResponse("500","Invalid request"), id, requestedQuantity);
        }

        // Fetch product from Database
        Optional<ProductData> productDataFromDb = productDataRepository.findById(id);

        ProductData productData = productDataFromDb.orElse(null);

        if (productData == null) {
            return new FailedQuoteResponse(new ErrorResponse("500","No product found with given id"), id, requestedQuantity);
        }

        if (productData.getQuantity() < requestedQuantity) {
            return new FailedQuoteResponse(new ErrorResponse("500","Product unavailable"), id, requestedQuantity);
        }

        Product productInfo = Product.
                builder()
                .setId(id)
                .setName(productData.getName())
                .setPrice(productData.getPrice())
                .setRequestedQuantity(requestedQuantity)
                .build();

        ProductQuoteResponse productQuoteResponse = new ProductQuoteResponse(productInfo, requestedQuantity);
        productQuoteResponse.setAmountToBePaid();

        return productQuoteResponse;
    }
}
