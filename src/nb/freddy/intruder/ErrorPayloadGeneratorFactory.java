// Freddy the Serial(isation) Killer
// 
// Released as open source by NCC Group Plc - https://www.nccgroup.trust/
//
// Project link: https://github.com/nccgroup/freddy/
//
// Released under agpl-3.0 see LICENSE for more information

package nb.freddy.intruder;

import burp.IIntruderAttack;
import burp.IIntruderPayloadGenerator;
import burp.IIntruderPayloadGeneratorFactory;
import java.util.ArrayList;
import nb.freddy.modules.FreddyModule;

/***********************************************************
 * Burp Intruder payload generator factory for Freddy
 * payloads that are intended to aid manual testing by
 * inducing errors in affected parsers and reveal their
 * use.
 * 
 * Written by Nicky Bloor (@NickstaDB).
 **********************************************************/
public class ErrorPayloadGeneratorFactory implements IIntruderPayloadGeneratorFactory {
	/*******************
	 * Properties
	 ******************/
	private ArrayList<FreddyModule> _modules;
	
	/*******************
	 * Initialise the payload generator factory.
	 * 
	 * @param modules A list of loaded Freddy modules to retrieve payloads from.
	 ******************/
	public ErrorPayloadGeneratorFactory(ArrayList<FreddyModule> modules) {
		_modules = modules;
	}
	
	/*******************
	 * Get the name of the payload generator.
	 * 
	 * @return The name of the payload generator.
	 ******************/
	public String getGeneratorName() {
		return "Freddy - Error Payloads";
	}
	
	/*******************
	 * Create a new instance of the payload generator.
	 * 
	 * @param attack The Intruder attack, ignored.
	 * @return An instance of ErrorPayloadGenerator.
	 ******************/
	public IIntruderPayloadGenerator createNewInstance(IIntruderAttack attack) {
		return new ErrorPayloadGenerator(_modules, attack);
	}
}
