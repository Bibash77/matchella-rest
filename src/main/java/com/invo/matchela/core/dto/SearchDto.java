package com.invo.matchela.core.dto;

import com.invo.matchela.core.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto {

   private String userId;

   private String date;

   private OrderStatus orderStatus;

   private String orderCode;

   private String itemName;
}
