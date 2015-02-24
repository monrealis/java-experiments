package eu.vytenis.fitnesse;

import fitnesse.junit.FitNesseRunner;
import org.junit.runner.RunWith;

@RunWith(FitNesseRunner.class)
@FitNesseRunner.Suite("Tests.SumFixtureTest")
@FitNesseRunner.FitnesseDir(".")
@FitNesseRunner.OutputDir("target/fitnesse-results")
@FitNesseRunner.DebugMode(true)
public class SumFixtureTest {
}

