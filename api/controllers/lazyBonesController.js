'use strict';

const Gpio = require('onoff').Gpio;


exports.on = function (req, res) {
    var pin = req.params.pinNumber;
    pinOn(pin);

    res.json(true);
};


exports.off = function (req, res) {
    var pin = req.params.pinNumber;
    pinOff(pin);

    res.json(true);
};


exports.momentary = function (req, res) {
    var pin = req.params.pinNumber;
    console.log('Momentary push');
    pinOn(pin);
    setTimeout(pinOff, 500, pin);

    res.json(true);
};


function pinOn(pinNumber) {
    if (Gpio.accessible) {
        const pinGpio = new Gpio(pinNumber, 'out');
        pinGpio.writeSync(1)
        pinGpio.unexport();
        console.log('Pin on GPIO: ' + pinNumber);
    }else{
        console.log('Pin on, no GPIO: ' + pinNumber);
    }

}

function pinOff(pinNumber) {
    if (Gpio.accessible) {
        const pinGpio = new Gpio(pinNumber, 'out');
        pinGpio.writeSync(0)
        pinGpio.unexport();
        console.log('Pin off GPIO: ' + pinNumber);
    }else{
        console.log('Pin off, no GPIO: ' + pinNumber);
    }

    
}
