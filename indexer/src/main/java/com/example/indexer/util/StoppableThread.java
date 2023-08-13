package com.example.indexer.util;

public class StoppableThread extends Thread {
  protected volatile boolean stopNow;

  public StoppableThread() {
    this.stopNow = false;
  }

  public void stopNow() {
    stopNow = true;
    this.interrupt();
  }
}
