/*
Author:Dipayan Das
Roll:cs1726
IR
Assignment1 Method1
Prototype version
*/


public class DipayanProgressBar {
    public  void mainTest(String[] args)throws InterruptedException {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= 100; i++) {
            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");
            Thread.sleep(100);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        System.out.println("Processing: Done!");

    }
    private int pogressCharRottator=0;
    public void showProgress(String data){
        
        System.out.print("Processing: " + data + "\r");
        
    }



}