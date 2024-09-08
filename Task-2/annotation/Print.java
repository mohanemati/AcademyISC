package ir.freeland.spring.initialspring.annotation;

import org.springframework.stereotype.Service;

/**
 * Simple output handler
 *
 * Used only for demonstration purposes :P
 */
@Service
public class Print {
  public void doPrint(String value) {
    System.out.println("print anotation: " + value);
  }
}
