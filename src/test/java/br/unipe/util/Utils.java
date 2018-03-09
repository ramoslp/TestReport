package br.unipe.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import br.unipe.common.Parametro;
import br.unipe.common.Selenium;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utils {
	
	private static final SimpleDateFormat aFormat = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat hFormat = new SimpleDateFormat("HHmmss");
	
	public static void wait(final int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static File takeScreenshot(Boolean isError) {
		String folderDate = aFormat.format(Calendar.getInstance().getTime());
		String fileDate = hFormat.format(Calendar.getInstance().getTime());
		String evidencia = null;

		int nexID = 001;
		NumberFormat formatter = new DecimalFormat("000");
		nexID = Integer.parseInt(Parametro.CONTADOR_SCREENSHOT);
		if (isError) {
			evidencia = Parametro.METHOD_NAME_TEST.concat("_") + fileDate + "_"+ formatter.format(nexID) + "_ERRO";
		} else {
			evidencia = Parametro.METHOD_NAME_TEST.concat("_") + fileDate + "_"+ formatter.format(nexID);
		}

		BufferedImage image = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Selenium.getDriver()).getImage();
		File outputFile = new File("screen.jpg");
		File destFile = new File("src/test/resources/Evidencias/"+ folderDate.concat("/").concat("/").concat(Parametro.METHOD_NAME_TEST).concat("/").concat(evidencia) + ".jpeg");

		try {
			ImageIO.write(image, "JPEG", outputFile);
			FileUtils.copyFile(outputFile.getAbsoluteFile(), destFile, true);
			nexID++;
			Parametro.CONTADOR_SCREENSHOT = (formatter.format(nexID));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destFile;
	}

}