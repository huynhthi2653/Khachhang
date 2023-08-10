package presentation.Controllertest;

import domain.KhachhangService;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
public abstract class Command {
   protected KhachhangService KhachhangService;

   public Command(KhachhangService KhachhangService) {
      this.KhachhangService = KhachhangService;
   }

<<<<<<< HEAD
=======
=======
public abstract class Command  {
   private KhachhangService KhachhangService;
   public Command(KhachhangService KhachhangService) {
      this.KhachhangService = KhachhangService;
  }
>>>>>>> 86b9ad0301f730bc73ecc265e391585cc29e8dcf
>>>>>>> 4366b2b2845e9834daf14c9334dcfda4d3e2c52a
   public abstract void excute();
}
