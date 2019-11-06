# NegoSimulation: User Guide

This tool is meant to be used as a teaching material to add an element for fun for the evaluation of different options. The current position of the protagonist (on a scale) would be determined by the participants. Each alternative the protagonist would then be evaluated by the participants and the facilitor. In the consideration of multiple options, the approximate impact of each of these options can be evaulated and inputted into the program. Upon the command `run`, the simulation is executed, revealing what would happen in the first 18 months after the chosen point in time, which, considering the case is from October 2018 onwards.

For now, there are three possible things that are considered in this simulation:

- Recurring Effects
- Random Effects
- Random Event / Action

## How to Use

1. Download the .jar file from the [Releases](https://github.com/rohan-av/NegoSimulation/releases/tag/v1.0) section
2. Ensure you have at least JDK 11 installed
3. Navigate to the folder and run the JAR file using bash / command prompt (`java -jar NegoSimulation.jar`)


## Input Formats

### Effect Creation

**Recurring Effects** refer to effects that can consistently change the protagonist's position with time, such as the case fading from public focus.

*Input format:*
`recur <description> <value_per_month>

*Example:*
`recur fading -1`

**Random Effects** are things that have a probability of happening each month, with a certain change happening if the effect were to happen.

*Input format:*
`randeff <description> <value> <probability>`

*Example:*
`randeff women_enter -1 0.65`

**Random Events / Actions** are either events that can change the situation by happening at a specific time (E.g. the national elections in Month 8, in my case), or actions carried out at a specific time by the protagonist. The impact of these events or actions are random, within a provided range.

*Input format:*
`randev <description> <lower_bound_value> <upper_bound_value> <time_of_event/action>`

*Example:*
`randev political_change_after_elections 1 5 8`

### Setting and Running

`set` is a command used to set the current position of the protagonist.

*Input format:*
`set <position>`

`run` is used to run the simulation.

*Input format:*
`run`


## Limitations

Needless to say, this program is only intended to be a fun teaching tool to help encourage the careful analysis of different choices. In many cases, the continued impact of different effects are not linear, some situations will always be unaccounted for, and it is fundamentally difficult to truly quantify the effectiveness of an option. 
