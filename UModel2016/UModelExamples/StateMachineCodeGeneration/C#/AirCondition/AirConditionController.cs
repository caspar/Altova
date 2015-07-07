////////////////////////////////////////////////////////////////////////
//
// AirConditionController.cs
//
// This file was generated by UModel 2011r2 Enterprise Edition
//
// YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
// OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
//
// Refer to the UModel Documentation for further details.
// http://www.altova.com/umodel
//
////////////////////////////////////////////////////////////////////////
using System;

namespace AirCondition
{
	public class AirConditionController
	{
		public enum TStateId
		{
			AirCondition_Root,
			AirCondition_MainRegion_Operating,
			AirCondition_MainRegion_Operating_RegionMode_Heater,
			AirCondition_MainRegion_Operating_RegionMode_Cooler,
			AirCondition_MainRegion_Operating_RegionSpeed_High,
			AirCondition_MainRegion_Operating_RegionSpeed_Off,
			AirCondition_MainRegion_Operating_RegionSpeed_Low,
			AirCondition_MainRegion_Off,
			AirCondition_MainRegion_Standby
		}

		public interface IState
		{
			string getName();
			TStateId getId();
			IRegion[] getRegions();
		}

		public interface IRegion
		{
			string getName();
			IState[] getStates();
			IState getCurrentState();
		}

		// get the Root State
		public IState getRootState()
		{
			return _getRootState();
		}
		public IState getCurrentTopLevelState()
		{
			return getRootState().getRegions()[0].getCurrentState();
		}

		// Initialize the State Machine
		public void Initialize()
		{
			OnDebugMessage( "BEGIN_INITIALIZE" );
			AirCondition_MainRegion_Operating = new CAirCondition.MainRegion.Operating(this);
			AirCondition_MainRegion_Operating_RegionMode_Heater = new CAirCondition.MainRegion.Operating.RegionMode.Heater(this);
			AirCondition_MainRegion_Operating_RegionMode_Cooler = new CAirCondition.MainRegion.Operating.RegionMode.Cooler(this);
			AirCondition_MainRegion_Operating_RegionSpeed_High = new CAirCondition.MainRegion.Operating.RegionSpeed.High(this);
			AirCondition_MainRegion_Operating_RegionSpeed_Off = new CAirCondition.MainRegion.Operating.RegionSpeed.Off(this);
			AirCondition_MainRegion_Operating_RegionSpeed_Low = new CAirCondition.MainRegion.Operating.RegionSpeed.Low(this);
			AirCondition_MainRegion_Off = new CAirCondition.MainRegion.Off(this);
			AirCondition_MainRegion_Standby = new CAirCondition.MainRegion.Standby(this);

			rootState = new CAirCondition(this);

			CAirCondition.MainRegion.setCurrentState(this, CAirCondition.MainRegion.getInitState(this));
			CAirCondition.MainRegion.Operating.RegionMode.setCurrentState(this, CAirCondition.MainRegion.Operating.RegionMode.getInitState(this));
			CAirCondition.MainRegion.Operating.RegionSpeed.setCurrentState(this, CAirCondition.MainRegion.Operating.RegionSpeed.getInitState(this));
			OnDebugMessage( "END_INITIALIZE" );
		}

		// get all possible call event actions
		public delegate bool CallEventAction();
		public CallEventAction[] getCallEvents()
		{
			return new CallEventAction[] {
				new CallEventAction(modeSelect),
				new CallEventAction(powerButton),
				new CallEventAction(speedSelect),
				new CallEventAction(standbyButton)
			};
		}

		// call event method implementations
		public bool modeSelect()
		{
			OnDebugMessage("BEGIN_EVENT: modeSelect");
			bool bHandled = _getRootState().modeSelect();
			OnDebugMessage("END_EVENT: modeSelect");
			return bHandled;
		}
		public bool powerButton()
		{
			OnDebugMessage("BEGIN_EVENT: powerButton");
			bool bHandled = _getRootState().powerButton();
			OnDebugMessage("END_EVENT: powerButton");
			return bHandled;
		}
		public bool speedSelect()
		{
			OnDebugMessage("BEGIN_EVENT: speedSelect");
			bool bHandled = _getRootState().speedSelect();
			OnDebugMessage("END_EVENT: speedSelect");
			return bHandled;
		}
		public bool standbyButton()
		{
			OnDebugMessage("BEGIN_EVENT: standbyButton");
			bool bHandled = _getRootState().standbyButton();
			OnDebugMessage("END_EVENT: standbyButton");
			return bHandled;
		}

		// Overwrite to handle entry/exit/do actions, transition effects,...:
		public virtual void OnEntryHeater() {OnDebugMessage("ACTION: OnEntryHeater");}
		public virtual void OnExitHeater() {OnDebugMessage("ACTION: OnExitHeater");}
		public virtual void OnEntryCooler() {OnDebugMessage("ACTION: OnEntryCooler");}
		public virtual void OnExitCooler() {OnDebugMessage("ACTION: OnExitCooler");}
		public virtual void OnEntryOperating() {OnDebugMessage("ACTION: OnEntryOperating");}
		public virtual void OnExitOperating() {OnDebugMessage("ACTION: OnExitOperating");}
		public virtual void OnEntryStandby() {OnDebugMessage("ACTION: OnEntryStandby");}
		public virtual void OnExitStandby() {OnDebugMessage("ACTION: OnExitStandby");}
		public virtual void On_Off_Operating_Effect() {OnDebugMessage("ACTION: On_Off_Operating_Effect");}

		// Overwrite to handle debug messages:
		public virtual void OnDebugMessage(string str)
		{
			if ( !str.StartsWith("BEGIN_EVENT" ) && !str.StartsWith( "END_EVENT" ) && !str.StartsWith( "BEGIN_INITIALIZE" ) && !str.StartsWith( "END_INITIALIZE" ) )
				System.Diagnostics.Debug.WriteLine("\t"+ str);
			else
				System.Diagnostics.Debug.WriteLine(str);
		}

		// Internal Definitions and Implementations

		// Root State Definition
		private CAirCondition rootState = null;
		private CAirCondition _getRootState()
		{
			if(rootState == null)
				Initialize();

			return rootState;
		}

		// State Variable Definitions
		private CAirCondition.MainRegion.Operating AirCondition_MainRegion_Operating = null;
		private CAirCondition.MainRegion.Operating.RegionMode.Heater AirCondition_MainRegion_Operating_RegionMode_Heater = null;
		private CAirCondition.MainRegion.Operating.RegionMode.Cooler AirCondition_MainRegion_Operating_RegionMode_Cooler = null;
		private CAirCondition.MainRegion.Operating.RegionSpeed.High AirCondition_MainRegion_Operating_RegionSpeed_High = null;
		private CAirCondition.MainRegion.Operating.RegionSpeed.Off AirCondition_MainRegion_Operating_RegionSpeed_Off = null;
		private CAirCondition.MainRegion.Operating.RegionSpeed.Low AirCondition_MainRegion_Operating_RegionSpeed_Low = null;
		private CAirCondition.MainRegion.Off AirCondition_MainRegion_Off = null;
		private CAirCondition.MainRegion.Standby AirCondition_MainRegion_Standby = null;

		// Implementation for StateMachine 'AirCondition'
		private class CAirCondition : IState
		{
			private AirConditionController context;
			private MainRegion.MainRegionState svMainRegion; // State Variable for Region 'MainRegion'

			public CAirCondition(AirConditionController context)
			{
				this.context = context;
			}
			public string getName()
			{
				return "AirCondition";
			}
			public TStateId getId()
			{
				return TStateId.AirCondition_Root;
			}
			public IRegion[] getRegions()
			{
				return new IRegion[] {
					new MainRegion(context)
				};
			}
			public bool modeSelect()
			{
				return MainRegion.getCurrentState(context).modeSelect();
			}
			public bool powerButton()
			{
				return MainRegion.getCurrentState(context).powerButton();
			}
			public bool speedSelect()
			{
				return MainRegion.getCurrentState(context).speedSelect();
			}
			public bool standbyButton()
			{
				return MainRegion.getCurrentState(context).standbyButton();
			}

			// Implementation for Region 'MainRegion'
			public class MainRegion : IRegion
			{
				private AirConditionController context;

				public MainRegion(AirConditionController context)
				{
					this.context = context;
				}
				public string getName()
				{
					return "MainRegion";
				}
				public IState[] getStates()
				{
					 return new IState[] {
						new Operating(context),
						new Off(context),
						new Standby(context)
					};
				}
				public IState getCurrentState()
				{
					return getCurrentState(context);
				}
				public static MainRegionState getCurrentState(AirConditionController context)
				{
					return context._getRootState().svMainRegion;
				}
				public static void setCurrentState(AirConditionController context, MainRegionState state)
				{
					context.OnDebugMessage( "SET_CURRENT_STATE: " + state.getName() );
					context._getRootState().svMainRegion = state;
					context._getRootState().svMainRegion.entryState();
				}
				public static MainRegionState getInitState(AirConditionController context)
				{
					return context.AirCondition_MainRegion_Off;
				}

				// Base class for all states of Region 'MainRegion'
				public abstract class MainRegionState : IState
				{
					protected AirConditionController context;
					public virtual bool modeSelect() {return false;}
					public virtual bool powerButton() {return false;}
					public virtual bool speedSelect() {return false;}
					public virtual bool standbyButton() {return false;}
					public virtual void initSubStates() {}
					public virtual void entryState() {}
					public virtual void exitState() {}
					public abstract string getName();
					public abstract TStateId getId();
					public abstract IRegion[] getRegions();
				}

				// Implementation for State 'Operating'
				public class Operating : MainRegionState
				{
					private RegionMode.RegionModeState svRegionMode; // State Variable for Region 'RegionMode'
					private RegionSpeed.RegionSpeedState svRegionSpeed; // State Variable for Region 'RegionSpeed'

					public Operating(AirConditionController context)
					{
						this.context = context;
					}
					public override string getName()
					{
						return "Operating";
					}
					public override TStateId getId()
					{
						return TStateId.AirCondition_MainRegion_Operating;
					}
					public override IRegion[] getRegions()
					{
						return new IRegion[] {
							new RegionMode(context),
							new RegionSpeed(context)
						};
					}
					public override bool modeSelect()
					{
						if(RegionMode.getCurrentState(context).modeSelect())
							return true;

						return false;
					}
					public override bool powerButton()
					{
						// Handle Operating ---> Off
						context.OnDebugMessage( "TRANSITION: Operating ---> Off");
						exitState();
						context.On_Off_Operating_Effect(); // Handle effect of transition Operating ---> Off
						CAirCondition.MainRegion.setCurrentState(context, context.AirCondition_MainRegion_Off);
						return true;
					}
					public override bool speedSelect()
					{
						if(RegionSpeed.getCurrentState(context).speedSelect())
							return true;

						return false;
					}
					public override bool standbyButton()
					{
						// Handle Operating ---> Standby
						context.OnDebugMessage( "TRANSITION: Operating ---> Standby");
						exitState();
						CAirCondition.MainRegion.setCurrentState(context, context.AirCondition_MainRegion_Standby);
						return true;
					}
					public override void entryState()
					{
						context.OnEntryOperating();
					}
					public override void exitState()
					{
						RegionMode.getCurrentState(context).exitState();
						context.OnExitOperating();
					}
					public override void initSubStates()
					{
						RegionMode.setCurrentState(context, RegionMode.getInitState(context));
						RegionSpeed.setCurrentState(context, RegionSpeed.getInitState(context));
					}

					// Implementation for Region 'RegionMode'
					public class RegionMode : IRegion
					{
						private AirConditionController context;

						public RegionMode(AirConditionController context)
						{
							this.context = context;
						}
						public string getName()
						{
							return "RegionMode";
						}
						public IState[] getStates()
						{
							 return new IState[] {
								new Heater(context),
								new Cooler(context)
							};
						}
						public IState getCurrentState()
						{
							return getCurrentState(context);
						}
						public static RegionModeState getCurrentState(AirConditionController context)
						{
							return context.AirCondition_MainRegion_Operating.svRegionMode;
						}
						public static void setCurrentState(AirConditionController context, RegionModeState state)
						{
							context.OnDebugMessage( "SET_CURRENT_STATE: " + state.getName() );
							context.AirCondition_MainRegion_Operating.svRegionMode = state;
							context.AirCondition_MainRegion_Operating.svRegionMode.entryState();
						}
						public static RegionModeState getInitState(AirConditionController context)
						{
							return context.AirCondition_MainRegion_Operating_RegionMode_Heater;
						}

						// Base class for all states of Region 'RegionMode'
						public abstract class RegionModeState : IState
						{
							protected AirConditionController context;
							public virtual bool modeSelect() {return false;}
							public virtual void entryState() {}
							public virtual void exitState() {}
							public abstract string getName();
							public abstract TStateId getId();
							public abstract IRegion[] getRegions();
						}

						// Implementation for State 'Heater'
						public class Heater : RegionModeState
						{
							public Heater(AirConditionController context)
							{
								this.context = context;
							}
							public override string getName()
							{
								return "Heater";
							}
							public override TStateId getId()
							{
								return TStateId.AirCondition_MainRegion_Operating_RegionMode_Heater;
							}
							public override IRegion[] getRegions()
							{
								return new IRegion[] {
								};
							}
							public override bool modeSelect()
							{
								// Handle Heater ---> Cooler
								context.OnDebugMessage( "TRANSITION: Heater ---> Cooler");
								exitState();
								CAirCondition.MainRegion.Operating.RegionMode.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionMode_Cooler);
								return true;
							}
							public override void entryState()
							{
								context.OnEntryHeater();
							}
							public override void exitState()
							{
								context.OnExitHeater();
							}
						}

						// Implementation for State 'Cooler'
						public class Cooler : RegionModeState
						{
							public Cooler(AirConditionController context)
							{
								this.context = context;
							}
							public override string getName()
							{
								return "Cooler";
							}
							public override TStateId getId()
							{
								return TStateId.AirCondition_MainRegion_Operating_RegionMode_Cooler;
							}
							public override IRegion[] getRegions()
							{
								return new IRegion[] {
								};
							}
							public override bool modeSelect()
							{
								// Handle Cooler ---> Heater
								context.OnDebugMessage( "TRANSITION: Cooler ---> Heater");
								exitState();
								CAirCondition.MainRegion.Operating.RegionMode.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionMode_Heater);
								return true;
							}
							public override void entryState()
							{
								context.OnEntryCooler();
							}
							public override void exitState()
							{
								context.OnExitCooler();
							}
						}
					}

					// Implementation for Region 'RegionSpeed'
					public class RegionSpeed : IRegion
					{
						private AirConditionController context;

						public RegionSpeed(AirConditionController context)
						{
							this.context = context;
						}
						public string getName()
						{
							return "RegionSpeed";
						}
						public IState[] getStates()
						{
							 return new IState[] {
								new High(context),
								new Off(context),
								new Low(context)
							};
						}
						public IState getCurrentState()
						{
							return getCurrentState(context);
						}
						public static RegionSpeedState getCurrentState(AirConditionController context)
						{
							return context.AirCondition_MainRegion_Operating.svRegionSpeed;
						}
						public static void setCurrentState(AirConditionController context, RegionSpeedState state)
						{
							context.OnDebugMessage( "SET_CURRENT_STATE: " + state.getName() );
							context.AirCondition_MainRegion_Operating.svRegionSpeed = state;
						}
						public static RegionSpeedState getInitState(AirConditionController context)
						{
							return context.AirCondition_MainRegion_Operating_RegionSpeed_Off;
						}

						// Base class for all states of Region 'RegionSpeed'
						public abstract class RegionSpeedState : IState
						{
							protected AirConditionController context;
							public virtual bool speedSelect() {return false;}
							public abstract string getName();
							public abstract TStateId getId();
							public abstract IRegion[] getRegions();
						}

						// Implementation for State 'High'
						public class High : RegionSpeedState
						{
							public High(AirConditionController context)
							{
								this.context = context;
							}
							public override string getName()
							{
								return "High";
							}
							public override TStateId getId()
							{
								return TStateId.AirCondition_MainRegion_Operating_RegionSpeed_High;
							}
							public override IRegion[] getRegions()
							{
								return new IRegion[] {
								};
							}
							public override bool speedSelect()
							{
								// Handle High ---> Off
								context.OnDebugMessage( "TRANSITION: High ---> Off");
								CAirCondition.MainRegion.Operating.RegionSpeed.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionSpeed_Off);
								return true;
							}
						}

						// Implementation for State 'Off'
						public class Off : RegionSpeedState
						{
							public Off(AirConditionController context)
							{
								this.context = context;
							}
							public override string getName()
							{
								return "Off";
							}
							public override TStateId getId()
							{
								return TStateId.AirCondition_MainRegion_Operating_RegionSpeed_Off;
							}
							public override IRegion[] getRegions()
							{
								return new IRegion[] {
								};
							}
							public override bool speedSelect()
							{
								// Handle Off ---> Low
								context.OnDebugMessage( "TRANSITION: Off ---> Low");
								CAirCondition.MainRegion.Operating.RegionSpeed.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionSpeed_Low);
								return true;
							}
						}

						// Implementation for State 'Low'
						public class Low : RegionSpeedState
						{
							public Low(AirConditionController context)
							{
								this.context = context;
							}
							public override string getName()
							{
								return "Low";
							}
							public override TStateId getId()
							{
								return TStateId.AirCondition_MainRegion_Operating_RegionSpeed_Low;
							}
							public override IRegion[] getRegions()
							{
								return new IRegion[] {
								};
							}
							public override bool speedSelect()
							{
								// Handle Low ---> High
								context.OnDebugMessage( "TRANSITION: Low ---> High");
								CAirCondition.MainRegion.Operating.RegionSpeed.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionSpeed_High);
								return true;
							}
						}
					}
				}

				// Implementation for State 'Off'
				public class Off : MainRegionState
				{
					public Off(AirConditionController context)
					{
						this.context = context;
					}
					public override string getName()
					{
						return "Off";
					}
					public override TStateId getId()
					{
						return TStateId.AirCondition_MainRegion_Off;
					}
					public override IRegion[] getRegions()
					{
						return new IRegion[] {
						};
					}
					public override bool powerButton()
					{
						// Handle Off ---> <Fork>
						context.OnDebugMessage( "TRANSITION: Off ---> <Fork>");
						CAirCondition.MainRegion.setCurrentState(context, context.AirCondition_MainRegion_Operating);
						// Handle <Fork> ---> Heater
						context.OnDebugMessage( "TRANSITION: <Fork> ---> Heater");
						CAirCondition.MainRegion.Operating.RegionMode.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionMode_Heater);
						// Handle <Fork> ---> Low
						context.OnDebugMessage( "TRANSITION: <Fork> ---> Low");
						CAirCondition.MainRegion.Operating.RegionSpeed.setCurrentState(context, context.AirCondition_MainRegion_Operating_RegionSpeed_Low);
						return true;
					}
				}

				// Implementation for State 'Standby'
				public class Standby : MainRegionState
				{
					public Standby(AirConditionController context)
					{
						this.context = context;
					}
					public override string getName()
					{
						return "Standby";
					}
					public override TStateId getId()
					{
						return TStateId.AirCondition_MainRegion_Standby;
					}
					public override IRegion[] getRegions()
					{
						return new IRegion[] {
						};
					}
					public override bool standbyButton()
					{
						// Handle Standby ---> <Fork>
						context.OnDebugMessage( "TRANSITION: Standby ---> <Fork>");
						exitState();
						CAirCondition.MainRegion.setCurrentState(context, context.AirCondition_MainRegion_Operating);
						// Handle <Fork> ---> <ShallowHistory>
						context.OnDebugMessage( "TRANSITION: <Fork> ---> <ShallowHistory>");
						CAirCondition.MainRegion.Operating.RegionMode.getCurrentState(context).entryState();
						// Handle <Fork> ---> <ShallowHistory>
						context.OnDebugMessage( "TRANSITION: <Fork> ---> <ShallowHistory>");
						return true;
					}
					public override void entryState()
					{
						context.OnEntryStandby();
					}
					public override void exitState()
					{
						context.OnExitStandby();
					}
				}
			}
		}
	}
}