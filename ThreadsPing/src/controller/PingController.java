package controller;

import java.io.*;

public class PingController extends Thread
{
private String proc;

public PingController(String proc)
 {
this.proc = proc;
 }

 public void run()
 {
readProcess(proc);
 }
 
 private void readProcess(String proc)
 {
String[] procvt = proc.split(" ");
long inicio = 0;
long fim = 0;
try
{
Process p = Runtime.getRuntime().exec(procvt);
InputStream fluxo = p.getInputStream();
InputStreamReader ler = new InputStreamReader(fluxo);
BufferedReader buffer = new BufferedReader(ler);
String linha = buffer.readLine();
while (linha != null)
{
inicio = System.nanoTime();
if (linha.contains("uol"))
{
System.out.println("UOL");
fim = System.nanoTime();
linha = buffer.readLine();
}else if (linha.contains("terra"))
{
System.out.println("Terra");
fim = System.nanoTime();
linha = buffer.readLine();
}else if (linha.contains("google"))
{
System.out.println("Google");
fim = System.nanoTime();
linha = buffer.readLine();
}
}  
System.out.println("A duração da operação é de " + (fim - inicio)/ Math.pow(10, 9) + " segundos" );
buffer.close();
ler.close();
fluxo.close();
}catch (Exception e)
{
System.err.println(e.getMessage());
}
 }
}
