package task3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class SearchFile implements Callable<String[]> {

	private String target;
	private ArrayList<Future<String[]>> resList;
	private File dir;
	private ExecutorService exSer;

	private SearchFile(String target, File dir, ArrayList<Future<String[]>> resList, ExecutorService exSer) {
		super();
		this.target = target;
		this.resList = resList;
		this.dir = dir;
		this.exSer = exSer;
	}

	public SearchFile(String target, File dir) {
		super();
		this.target = target;
		this.dir = dir;
		this.resList = new ArrayList<>();
		this.exSer = Executors.newFixedThreadPool(100);

	}

	public SearchFile() {
		super();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	private String[] getResultOfSearching() {
		String[] resultStr = new String[0];
		String[] itrerRes;
		try {
			for (Future<String[]> future : resList) {
				if (future != null) {
					itrerRes = future.get(); 
					if(itrerRes != null) {
						for (String string : itrerRes) {
							resultStr = Arrays.copyOf(resultStr, resultStr.length + 1);
							resultStr[resultStr.length - 1] = string;
						}
					}
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		exSer.shutdown();
		return resultStr;
	}

	public String[] findFile() {
		resList.add(exSer.submit(this));
		if (dir.isDirectory() && dir.exists()) {
			nestedDirectory(dir);
		}
		return getResultOfSearching();
	}

	private void nestedDirectory(File fl) {
		File[] fileList = fl.listFiles();
		for (File file : fileList) {
			if (file.isDirectory()) {
				resList.add(exSer.submit(new SearchFile(target, file, resList, exSer)));
				nestedDirectory(file);
			}
		}
	}

	@Override
	public String[] call() {
		String[] res = new String[0];
		if (!dir.exists() || (dir.isFile() && (dir.getName().indexOf(target) < 0))) {
			return null;
		} else if ((dir.isFile() && (dir.getName().indexOf(target) >= 0))) {
			res = Arrays.copyOf(res, res.length + 1);
			res[res.length - 1] = dir.getAbsolutePath();
		} else {
			File[] fileList = dir.listFiles();
			for (File file : fileList) {
				if (file.isFile() && (file.getName().indexOf(target) >= 0)) {
					res = Arrays.copyOf(res, res.length + 1);
					res[res.length - 1] = file.getAbsolutePath();
				}
			}
		}
		return res;
	}

}