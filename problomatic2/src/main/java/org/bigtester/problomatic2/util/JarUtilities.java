package org.bigtester.problomatic2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class JarUtilities {

	public static void createJar(String jarPath) throws FileNotFoundException,
			IOException {
		File file = new File(jarPath);
		JarOutputStream out = new JarOutputStream(new FileOutputStream(file),
				new Manifest());
		out.flush();
		out.close();
	}

	/**
	 * Adds the specified file to the jar
	 * 
	 * @param jarFile
	 * @param aFile
	 * @throws IOException
	 */
	public static void addToJar(String jarPath, String filePath)
			throws IOException {
		byte[] buffer = new byte[1024];
		int bytesRead;
		File aFile = new File(filePath);
		File jarFile = new File(jarPath);
		FileInputStream file = new FileInputStream(aFile);
		FileOutputStream out = new FileOutputStream(jarFile);
		JarOutputStream jar = new JarOutputStream(out);
		JarEntry entry = new JarEntry(aFile.getName());
		jar.putNextEntry(entry);
		while ((bytesRead = file.read(buffer)) != -1) {
			jar.write(buffer, 0, bytesRead);
		}
		jar.close();
		file.close();
	}
	
	public static void extractAll(String jarPath, String destination)
			throws IOException {
		File file = new File(destination);
		if (!file.exists()) {
			file.createNewFile();
		}
		JarFile jar = new JarFile(new File(jarPath));
		Enumeration entries = jar.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = (JarEntry) entries.nextElement();
			String destPath = destination + File.separatorChar
					+ entry.getName();
			InputStream in = jar.getInputStream(entry);
			FileOutputStream out = new FileOutputStream(destPath);
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			in.close();
			out.close();
		}

	}

}
