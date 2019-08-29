package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class BaseCalcFactory {

	// single-ton
	// è�ø�: primary -> ����Ŭ���� ����. primarytypename
	// _single ������ -> �ڵ����� �Է� ����
	static BaseCalcFactory single = null;

	public static BaseCalcFactory getInstance() {
		if (single == null)
			single = new BaseCalcFactory();
		return single;

	}

	public BaseCalc createBaseCalc() {
		BaseCalc calc = new BaseCalcImpl();
		return calc;
	}

}
