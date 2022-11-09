package demo.lombok.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Stu {
   public Stu(){
      log.info("111");
   }
   private int id;
   private int age;
}
