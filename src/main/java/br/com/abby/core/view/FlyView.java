package br.com.abby.core.view;

import br.com.abby.linear.AimPoint;
import br.com.abby.linear.Camera;
import br.com.etyllica.core.event.KeyEvent;
import br.com.etyllica.core.event.PointerEvent;

public class FlyView {

	protected AimPoint aim;

	public float turnSpeed = 4f;
	public float walkSpeed = 2.5f;

	protected boolean forwardPressed = false;
	protected boolean backwardPressed = false;
	protected boolean strafeLeftPressed = false;
	protected boolean strafeRightPressed = false;
	
	protected boolean upPressed = false;
	protected boolean downPressed = false;
	protected boolean leftPressed = false;
	protected boolean rightPressed = false;
	protected boolean liftPressed = false;
	protected boolean divePressed = false;

	public FlyView(float x, float y, float z) {
		aim = new AimPoint(x, y, z);
	}
	
	public FlyView(Camera camera) {
		aim = new AimPoint(camera.position.x, camera.position.y, camera.position.z);
	}

	public AimPoint getAim() {
		return aim;
	}

	public void setAim(AimPoint aim) {
		this.aim = aim;
	}

	public float getX() {
		return aim.x;
	}

	public float getY() {
		return aim.y;
	}

	public float getZ() {
		return aim.z;
	}

	public void update(long now) {

		if(forwardPressed) {
			aim.moveXZ(-walkSpeed);
		}

		if(backwardPressed) {
			aim.moveXZ(walkSpeed);	
		}

		if(upPressed) {
			aim.offsetAngleX(turnSpeed);
		}

		if(downPressed) {
			aim.offsetAngleX(-turnSpeed);
		}

		if(leftPressed) {
			aim.offsetAngleY(+turnSpeed);			
		}

		if(rightPressed) {
			aim.offsetAngleY(-turnSpeed);			
		}

		if(liftPressed) {
			aim.y += walkSpeed;
		}
		
		if(divePressed) {
			aim.y -= walkSpeed;
		}

	}

	public void updateKeyboard(KeyEvent event) {
		if(event.isKeyDown(KeyEvent.VK_W)) {
			forwardPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_W)) {
			forwardPressed = false;
		}

		if(event.isKeyDown(KeyEvent.VK_S)) {
			backwardPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_S)) {
			backwardPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.VK_A)) {
			strafeLeftPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_A)) {
			strafeLeftPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.VK_D)) {
			strafeRightPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_D)) {
			strafeRightPressed = false;
		}

		if(event.isKeyDown(KeyEvent.VK_UP_ARROW)) {
			upPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_UP_ARROW)) {
			upPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.VK_DOWN_ARROW)) {
			downPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_DOWN_ARROW)) {
			downPressed = false;
		}

		if(event.isKeyDown(KeyEvent.VK_RIGHT_ARROW)) {
			rightPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_RIGHT_ARROW)) {
			rightPressed = false;
		}

		if(event.isKeyDown(KeyEvent.VK_LEFT_ARROW)) {
			leftPressed = true;			
		} else if(event.isKeyUp(KeyEvent.VK_LEFT_ARROW)) {
			leftPressed = false;
		}

		if(event.isKeyDown(KeyEvent.VK_SPACE)) {
			liftPressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_SPACE)) {
			liftPressed = false;
		}
		
		if(event.isKeyDown(KeyEvent.VK_N)) {
			divePressed = true;
		} else if(event.isKeyUp(KeyEvent.VK_N)) {
			divePressed = false;
		}
	}
	
	public void updateMouse(PointerEvent event) {
		
	}

}
