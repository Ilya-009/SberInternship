package com.sbertech;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DataContainer {
    private Integer hour;
    private Integer priority;
    private String description;
}
