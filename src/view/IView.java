package view;

import controller.IController;
import javafx.scene.Parent;

public interface IView {
	
	
	IButton getButtonStart();

	void setController(IController controller);

//	Parent getRoot();
	
//	void getButtonStart();
//	void getButtonStop();
//	void getButtonInc();
//	void getButtonDec();
//	void getDisplayTimeByMeasure();
//	void getDisplayTempo();
//	
//	public Dial getBPMDial();
//	public Led getBeatLed();
//	public Led getBarLed();
//	public Display getDisplay();
//	public Beep getBeep();
//	public Level getLevel();
//	public void attachHandlers(Controller controller);

}
