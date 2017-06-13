package methods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Methods {
	public static void writeNickName(String nick) {
		FileWriter fw;
		try {
			fw = new FileWriter("Nicknames.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(nick);
			bw.newLine();
			bw.close();
		}
		catch (IOException e) {
		}
	}

	public static void deletNicknameFile() {
		File f = new File("Nicknames.txt");
		f.delete();
	}
}
