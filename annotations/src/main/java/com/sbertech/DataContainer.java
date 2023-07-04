package com.sbertech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataContainer {
    private Integer id;
    private String userName;
    private Character[] password;
}
