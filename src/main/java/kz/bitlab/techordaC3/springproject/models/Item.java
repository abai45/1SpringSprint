package kz.bitlab.techordaC3.springproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
   private Long id;
   private String name;
   private String description;
   private double price;
}
