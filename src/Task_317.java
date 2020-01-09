import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_317 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		PresentCounter test = new PresentCounter(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class PresentCounter {
	private int counter;

	public PresentCounter(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String[] data = input.readLine().split(" ");
			int iris = Integer.parseInt(data[0]);
			int tangerine = Integer.parseInt(data[1]);
			int cake = Integer.parseInt(data[2]);
			int weight = Integer.parseInt(data[3]);

			int i = 0;
			while (i <= weight) {
				int t = 0;
				while (t <= weight) {
					int temp = i + t;
					if (temp > weight) {
						break;
					}
					if (temp == weight) {
						counter++;
					} else if ((weight - temp) % cake == 0) {
						counter++;
					}
					t += tangerine;
				}
				i += iris;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.valueOf(counter);
	}
}