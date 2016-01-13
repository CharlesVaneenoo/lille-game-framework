package gameframework.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapRulesApplier;

public class GameDataTest {

	GameConfiguration configuration;
	GameData data;
	ObservableValue<Integer> score;
	GameCanvas canvas;
	ObservableValue<Integer> life;
	List<GameLevel> levels;
	MoveBlockerRulesApplier moveBlockerRulesApplier;
	MoveBlockerChecker moveBlockerChecker;
	OverlapRulesApplier overlapRulesApplier;
	OverlapProcessor overlapProcessor;
	GameUniverse universe;
	ObservableValue<Boolean> endOfGame; 
	
	@Test
	public void getConfigurationTest() {
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		assertSame(configuration,data.getConfiguration());
	}
	
	@Test
	public void getScoreTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		score = new ObservableValue<Integer>(0);
		assertEquals(score.getValue(), data.getScore().getValue());
	}
	
	@Test
	public void getCanvasTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		canvas = configuration.createCanvas();
		assertEquals(canvas, data.getCanvas());
	}
	
	@Test
	public void getLifeTest(){
		GameConfiguration configuration = new GameConfiguration(2,2,2,2);
		GameData data = new GameData(configuration);
		life = new ObservableValue<Integer>(configuration.getDefaultNbLives());
		assertEquals(life.getValue(), data.getLife().getValue());

	}
	
	@Test
	public void getEndOfGameTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		endOfGame = new ObservableValue<Boolean>(false);
		assertEquals(endOfGame.getValue(), data.getEndOfGame().getValue());
	}
	
	@Test
	public void getLevelsTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		levels = new ArrayList<GameLevel>();
		assertEquals(levels, data.getLevels());
	}
	
	@Test
	public void getMoveBlockerRulesApplierTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		moveBlockerRulesApplier = configuration.createMoveBlockerRulesApplier();
		moveBlockerRulesApplier.setGameData(data);
		assertEquals(moveBlockerRulesApplier, data.getMoveBlockerRulesApplier());
	}
	
	@Test
	public void getMoveBlockerCheckerTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		moveBlockerChecker = configuration.createMoveBlockerChecker();
		moveBlockerChecker.setMoveBlockerRules(moveBlockerRulesApplier);
		assertEquals(moveBlockerChecker, data.getMoveBlockerChecker());
	}
	
	@Test
	public void getOverlapProcessorTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		overlapProcessor = configuration.createOverlapProcessor();
		overlapProcessor.setOverlapRules(overlapRulesApplier);
		assertEquals(overlapProcessor, data.getOverlapProcessor());
	}
	
	@Test
	public void getOverlapRulesApplierTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		overlapRulesApplier = configuration.createOverlapRulesApplier();
		overlapRulesApplier.setGameData(data);
		assertEquals(overlapRulesApplier, data.getOverlapRulesApplier());
	}
	
	@Test
	public void getUniverseTest(){
		GameConfiguration configuration = new GameConfiguration();
		GameData data = new GameData(configuration);
		universe = configuration.createUniverse();
		universe.setGameData(data);
		assertEquals(universe, data.getUniverse());
	}
	
}
