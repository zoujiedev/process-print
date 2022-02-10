package com.zoujiepro.tools.provider;

import com.zoujiepro.tools.define.ProcessPrinter;

/**
 * @Classname SimpleProcessPrinter
 * @Description TODO
 * @Date 2022-2-10 17:02
 * @Created by zoujie
 */
public class SimpleProcessPrinter implements ProcessPrinter {

  //当前打印进度记录(非线程安全)
  private  Integer currentProcess = null;

  //进度打印占位符
  private final String PROCESS_PLACEHOLDER = "==";

  @Override
  public void processPrint(int process) {
    //清除之前的进度打印数据
    String eraseLastChar = eraseLastChar();
    String processStr = String.format("%s[%s]", eraseLastChar + getPrefix(process), process);
    System.out.print(processStr);
    //记录当前打印进度
    currentProcess = process;
  }

  private String eraseLastChar() {
    if(currentProcess == null){
      return "";
    }
    //如果首次打印为0，则需要清理[0]这三个字符
    if(currentProcess == 0){
      return getBackStr(3);
    }
    //计算进度所占宽度 = 数字所占宽度 + 中括号两个宽度
    int processNumberWidth = String.valueOf(currentProcess).length() + 2;

    //计算占位符所占宽度
    int placeHolderWidth =  currentProcess / 10;
    return getBackStr(processNumberWidth + placeHolderWidth);
  }

  private String getPrefix(int process) {
    if(process <= MINI_PROCESS){
      return "";
    }
   return getPlaceHolder(process / 10);
  }

  private String getBackStr(int num){
    return getStrWithCount("\b",num);
  }

  private String getPlaceHolder(int num){
    return getStrWithCount(PROCESS_PLACEHOLDER,num);
  }

  private String getStrWithCount(String str,int count){
    String res = "";
    for (int i = 0; i < count; i++) {
      res += str;
    }
    return res;
  }

}
