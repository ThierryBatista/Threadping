package view;
import controller.PingController;

public class Ping
{
 public static void main(String Args[])
 {
 String ping1 = "ping -4 -n 10 www.google.com.br";
 String ping2 = "ping -4 -n 10 www.uol.com.br";
 String ping3 = "ping -4 -n 10 www.terra.com.br";
 
 Thread ping = new PingController(ping1);
 ping.start();
 Thread pings = new PingController(ping1);
 pings.start();
 Thread pingos = new PingController(ping1);
 pingos.start();
 }
}