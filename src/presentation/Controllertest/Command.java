package presentation.Controllertest;

import domain.KhachhangService;

<<<<<<< HEAD
public abstract class Command {
   protected KhachhangService KhachhangService;

   public Command(KhachhangService KhachhangService) {
      this.KhachhangService = KhachhangService;
   }

=======
public abstract class Command  {
   private KhachhangService KhachhangService;
   public Command(KhachhangService KhachhangService) {
      this.KhachhangService = KhachhangService;
  }
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
   public abstract void excute();
}
