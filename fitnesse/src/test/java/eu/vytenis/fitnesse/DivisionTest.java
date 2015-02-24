package eu.vytenis.fitnesse;

import fitnesse.junit.FitNesseRunner;
import org.junit.runner.RunWith;

@RunWith(FitNesseRunner.class)
@FitNesseRunner.Suite("Tests.DivisionTest")
@FitNesseRunner.DebugMode(true)
@FitNesseRunner.FitnesseDir(".")
@FitNesseRunner.OutputDir(systemProperty = "java.io.tmpdir", pathExtension = "fitnesse")
public class DivisionTest {

}
