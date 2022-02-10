package com.zoujiepro.tools.define;

/**
 * @Classname ProcessPrinter
 * @Description TODO
 * @Date 2022-2-10 17:01
 * @Created by zoujie
 */
public interface ProcessPrinter {

  byte MAX_PROCESS = 100;

  byte MINI_PROCESS = 0;

  void processPrint(int process);
}
