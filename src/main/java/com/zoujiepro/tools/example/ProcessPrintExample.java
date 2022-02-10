package com.zoujiepro.tools.example;

import com.zoujiepro.tools.provider.SimpleProcessPrinter;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ProcessPrintExample
 * @Description TODO
 * @Date 2022-2-10 18:30
 * @Created by zoujie
 */
public class ProcessPrintExample {

  public static void main(String[] args) throws InterruptedException {
    SimpleProcessPrinter simpleProcessPrinter = new SimpleProcessPrinter();

    for (int i = 0; i <= 100; i++) {
      simpleProcessPrinter.processPrint(i);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
