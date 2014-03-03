package com.apptonix.GameWorlds;

import com.apptonix.GameHelpers.AssetLoader;
import com.apptonix.GameObjects.Background;
import com.apptonix.GameObjects.Player;
import com.apptonix.GameObjects.ScrollHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera camera;
	
	private int
		gameHeight,
		gameWidth;
	
	private ScrollHandler scrollHandler;
	
	private Player player;
	
	private SpriteBatch spriteBatcher;
	
	private Background
		background,
		background2;
	
	private TextureRegion
		backgroundDesert,
		planeRed;
	
	private boolean debugMode = false;
	
	public GameRenderer(GameWorld pWorld, int pGameHeight, int pGameWidth) {
		
		world = pWorld;
		
		gameHeight = pGameHeight;
		gameWidth = pGameWidth;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1280, 720); // TODO This needs changing
		
		spriteBatcher = new SpriteBatch();
		spriteBatcher.setProjectionMatrix(camera.combined);
		
		initGameObjects();
		initAssets();
		
	}
	
	public void render(float runTime) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		spriteBatcher.begin();
		
		spriteBatcher.disableBlending();
		
		spriteBatcher.draw(backgroundDesert, background.getX(), background.getY(), background.getWidth(), background.getHeight());
		spriteBatcher.draw(backgroundDesert, background2.getX(), background2.getY(), background2.getWidth(), background2.getHeight());
		
		spriteBatcher.enableBlending();
		
		spriteBatcher.draw(planeRed, player.getX(), player.getY(), player.getWidth(), player.getHeight());
		
		spriteBatcher.end();
		
	}
	
	/*
	 * Load the game objects into the game renderer
	 */
	private void initGameObjects() {
		
		player = world.getPlayer();
		
		scrollHandler = world.getScrollHandler();
		
		background = scrollHandler.getBackground();
		background2 = scrollHandler.getBackground2();
		
	}
	
	/*
	 * Load the assets into the game renderer
	 */
	private void initAssets() {
		
		backgroundDesert = AssetLoader.backgroundDesert;
		planeRed = AssetLoader.planeRed;
		
	}

}
