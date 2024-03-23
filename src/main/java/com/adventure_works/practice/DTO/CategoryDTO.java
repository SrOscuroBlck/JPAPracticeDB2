package com.adventure_works.practice.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
@Getter
@Setter
public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSeralVersionUID() {
        return serialVersionUID;
    }
}
