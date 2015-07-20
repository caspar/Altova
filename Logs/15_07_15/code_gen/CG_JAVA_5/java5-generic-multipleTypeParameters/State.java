
interface IdleState{
	boolean isIdle();

}

public class State{
	public static <T extends Enum<T> & IdleState> void ShowState(EnumSet<T> set){
		// TODO add implementation
	}

	List<?> modifyList(List<?> list){
		// TODO add implementation
	}

}

