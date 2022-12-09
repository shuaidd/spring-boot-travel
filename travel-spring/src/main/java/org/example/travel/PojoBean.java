package org.example.travel;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@ToString
@Data
@Component
@Scope("prototype")
public class PojoBean {

    PojoBean() {
        this.age = new Random().nextInt(100,10000);
        this.name = "ddshuai" + this.age;
    }

    private String name ;

    private Integer  age;
}
