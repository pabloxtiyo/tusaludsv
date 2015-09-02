package com.tusaludsv.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class ResourceUtils {


	private static final String URL_PROTOCOL_JAR = "jar";
	private static final String URL_PROTOCOL_ZIP = "zip";
	private static final String URL_PROTOCOL_WSJAR = "wsjar";
	public static final String FILE_URL_PREFIX = "file:";
	public static final String URL_PROTOCOL_FILE = "file";
	
	
	
	/**
	 * Return whether the given resource handle indicates a jar resource
	 * that the <code>doFindPathMatchingJarResources</code> method can handle.
	 * <p>The default implementation checks against the URL protocols
	 * "jar", "zip" and "wsjar" (the latter are used by BEA WebLogic Server
	 * and IBM WebSphere, respectively, but can be treated like jar files).
	 * @param resource the resource handle to check
	 * (usually the root directory to start path matching from)
	 * @see #doFindPathMatchingJarResources
	 */
	public static boolean isJarResource(Resource resource) throws IOException {
		String protocol = resource.getURL().getProtocol();
		return (URL_PROTOCOL_JAR.equals(protocol) ||
				URL_PROTOCOL_ZIP.equals(protocol) ||
				URL_PROTOCOL_WSJAR.equals(protocol));
	}
	
	/**
	 * finds all resources as file-set by given path
	 * <p>Created by fr on 01.03.2007</p>
	 * @param path
	 * @return fileSet
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public static List<Resource> findResourcesByPath(String path) throws URISyntaxException, IOException {
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = pathMatchingResourcePatternResolver.getResources(path);
		List<Resource> resourceList = new ArrayList<Resource>();
		for (Resource resource : resources) {
			resourceList.add(resource);
		}
		return resourceList;
	}
	
	/**
	 * open's a input stream to given resource
	 * <p>Created by fr on 01.03.2007</p>
	 * @param resourcePath
	 * @return InputStream for given resource
	 * @throws IOException 
	 */
	public static InputStream getInputStreamForResource(String resourcePath) throws IOException {
		URL resource = Thread.currentThread().getContextClassLoader().getResource(resourcePath);
		return resource.openStream();
	}
	
    public static File getFileForResource(String resourcePath) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(resourcePath);
        if (resource == null)
            return null;
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            return null;
        }
    }
    
    public static URL getURLForResource(String resourcePath) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(resourcePath);
        return resource;
    }
    
	/**
	 * gets the filepath to given resource
	 * <p>Created by fr on 01.03.2007</p>
	 * @param resourcePath
	 * @return filePath
	 */
	public static String getRealFilePathForResource(String resourcePath) {
        File file = getFileForResource(resourcePath);
		if (file == null)
			return null;
        return file.getAbsolutePath(); 
	}
	
	/**
	 * changes extension of given resourceFileName
	 * <p>Created by fr on 07.03.2007</p>
	 * @param originalName
	 * @param newExtension
	 * @return resourceFileName with new extension
	 */
	public static String changeExtension(String originalName, String newExtension) {
		if (originalName == null)
			return null;
		int lastDot = originalName.lastIndexOf(".");
		if (lastDot != -1)
			return originalName.substring(0, lastDot) + newExtension;
		return originalName + newExtension;
	}
	
}
