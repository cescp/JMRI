JMRI Turnout Channels � Direct JMRI to Arduino Data Transfer
More extensive information about this project can be found here:
SMA29 JMRI Turnout Channels � Direct JMRI to Arduino Communications - Simple Support for Lots of Data Out From JMRI --  https://model-railroad-hobbyist.com/node/34417

This project on the Turnout Table in JMRI because it represents 2 states per turnout  � Open and Thrown. We will take up to 68 table entries at a time and connect them to the 68 respective pins on an Arduino Mega2560. The hardware connection can be made with most any off-the-shelf Arduino board (unmodified). The Arduino Mega2560 will support up to 68 turnouts, an Arduino Uno, Pro Mini, or Nano will support up to 18 outputs. These will connect via any USB port, to your computer running JMRI. This will be the same USB serial port you use to load the Arduino board.

A script (Turnout_Table_Build.py)  is included that you can run in JMRI to set up most any size �Turnout Table� you need, with the appropriate naming convention for these channels.

This �Turnout Channel� is built with an Arduino Mega2560 controller and an optional Mega Sensor shield, for about $12-16 total depending on where you purchase them. The Mega shield board literally plugs into the top of the Mega2560 board, and has two screw terminals where you can connect a 5 Volt power supply to power the assembly.  The shield board makes attaching your devices easier. Each corresponding signal (S) pin is numbered on the board from 2-53, and then from A0-A15 (corresponding to sensors 54-69). Pins 0 and 1 are taken for USB communication. These will correspond directly to the turnout number in the JMRI table. Each numbered connection on the shield provides a group of 3 pins with the signal connection (S), a+5 Volt pin (V), and a ground (negative side connection G). 

The Arduino Mega2560 will use all 68 pins as digital outputs. An Arduino UNO, a Pro Mini, and a Nano will have 18 pins available (Digital pins 2-13, and A0-A5 or Digital pins 14-19) for outputs. There are two different pre-configured sketches to load either a Mega or one of the smaller boards. Both sketches assume all pins are scanned as sensors and will match JMRI USER-DEFINED turnout names from AT2-AT69 or AT2-AT19 .  The AT designation is completely arbitrary, but if you want to change it you will have to edit theJMRI  TurnoutDataTransfer Python Script provided. Load the appropriate Arduino sketch onto your favorite board, attach a sensor shield if needed, and leave the board connected to your computer that you will run JMRI.

You have some options for setting up your turnout table for data transfer to your Arduino. The JMRI transfer script that will communicate with your Arduino will look for a set of user names  in your turnout table set up as AT2 � AT69, or shorter if you like. So if you already have entries in your table already set up and you haven�t given them user names you can edit each entry and add these in sequence, like AT2, AT3, AT4, etc�  or you can use the included script in the zip file called:  Turnout_Table_Build.py 


You can change first_turnout and last_turnout  to whatever range you would like. Remember the Arduino Mega2560 can handle 68 and the smaller ones can handle up to 18. Using the system name prefix IT will set these up as internally referenced turnouts (not a hardware address).  This script is easier to use than the internal sequenced add in the turnout table. After getting the entries correct, remember to save your panel by using Panels-> Save Panels� and name and save for later. You can set this file up to automatically load in the Preferences->Startup menu.
From the JMRI menu  go to Panels -> Run Script and find your up to date TurnoutDataTransfer.py file.   Run the script and you should see all your turnouts  go from �Unknown� to �Closed.� If you do not want the turnouts initialized at startup simply delete line 44 in the TurnoutDataTransfer.py  script:   turnout.setCommandedState(CLOSED)  

Do not get hung up with the term �Turnout� !! It is a throwback to early DCC days and terminology. Relative to this application it is simply a switch. BUT, with the power and connections internal to JMRI these can be linked to and controlled by many other things. So start by just thinking about them as a switch that, now, can reach outside of JMRI. Those modelers that have some familiarity with Arduinos will quickly realize that if you can set a single output bit in an Arduino, then you can do far more than just turning it on and off. It should be possible to burden the Mega2560 with a bit more work, like using the turnout bits to move servos and the like.
