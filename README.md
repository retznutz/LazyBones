# LazyBones
Hardwired API control of your remotes for home automation with devices that don't support it.

LazyBones is a node.js project that is designed to run on a RaspberryPi Zero W and provide and API to turn the Pi's GPIO on and off.  I'll be adding in some hardware ciruit diagrams and board layouts for basic switching control using the GPIO ports.

Once setup, rip open your remote for the device you want to control and hardwires the leads from the circuit board to your remote, configure the driver for your home automation system (or just call the URLs in your browser) and then, *automation*


## Home Automation
I'm using Hubitat, so the first drivers will be for the Hubitat system


## Why?
I have a couple of very nice light systems that I own that I want to have automated.  The remotes are propriatary and realtivly inexpensive, so ripping one open and wiring it up was the only way I could think of making it work.

Using a Raspberry Pi Zero is a low cost networked solution that I can run node on.  I considered Arduino, but by the time you add on Wifi the cost is more than a Pi Zero.
