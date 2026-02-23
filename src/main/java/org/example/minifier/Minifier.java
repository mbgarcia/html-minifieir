package org.example.minifier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Minifier {

	public static void main(String[] args) throws IOException {
		System.out.println("Minifying html file....");

		Path path = Path.of("input.html");
		
		java.util.List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		
		StringBuilder sb = new StringBuilder();

		RemoveSpacesBetweenTags removeSpaces = new RemoveSpacesBetweenTags();

		for (String line: lines) {
			sb.append(removeSpaces.sanitize(line.trim()));
		}
		
		write(HtmlEntityConverter.replaceSpecialCharacters(sb.toString()).replace("\"", "'"));
	}
	
	public static void write(String content) throws IOException {
        Path filePath = Paths.get("minified.html");

		Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));

		System.out.println("Content has been written to the file.");
	}
}