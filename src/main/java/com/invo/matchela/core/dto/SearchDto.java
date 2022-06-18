package com.invo.matchela.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto {

   private String userId;

   private String date;

   private String orderCode;

   private String itemName;
}
