import java.net.*;
import java.io.*;
public class Server
{
	public static void main(String []args) throws Exception
	{
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("Server Ready for chtting...");
		Socket s1=ss.accept();
		BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
		OutputStream os=s1.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		InputStream is=s1.getInputStream();
		BufferedReader rbr = new BufferedReader(new InputStreamReader(is));
		String rmsg,smsg;
		while(true)
		{
			if((rmsg=rbr.readLine())!=null)
			{
				System.out.println("\nClient says:"+rmsg);
			}
			smsg=sbr.readLine();
			pw.println(smsg);
			pw.flush();
		}
	}
}