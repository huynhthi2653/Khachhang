package presentation.Controllertest;

import domain.KhachhangService;

public abstract class Command  {
   private KhachhangService KhachhangService;
   public Command(KhachhangService KhachhangService) {
      this.KhachhangService = KhachhangService;
  }
   public abstract void excute();
}
