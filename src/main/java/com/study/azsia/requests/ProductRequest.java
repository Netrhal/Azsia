package com.study.azsia.requests;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private Long price;
    private String description;
    private String prodClass;
}
