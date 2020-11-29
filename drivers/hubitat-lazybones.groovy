/***********************************************************************************************************************
*  Copyright 2020 Matt Retzer
*
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*  LazyBones Driver
*
*  Author: Matt Retzer
*
*  Date: 11-23-2020
*
*  Features:
*   - TODO
*
***********************************************************************************************************************/

public static String version()      {  return "v1.0.0"  }

/***********************************************************************************************************************
*
* Version: 1.0.0
*   11-23-2020: initial version.
*/

import groovy.transform.Field

metadata    {
    definition (name: "LazyBones Driver", namespace: "retznutz", author: "Matt Retzer")  {
		capability "PushableButton"
		capability "Refresh"

        attribute "averageFuelConsumption", "number"
        
        command "pushButtonMomentary",["number"]
        command "pushButtonOn",["number"]
        command "pushButtonOff",["number"]
        command "refresh"
    }

    preferences {
		section {
				input (
					type: "text",
					name: "apiUrl",
					title: "LazyBones API Url",
					required: true				
				)
                input (
					type: "number",
					name: "delayAmount",
					title: "Momentary delay amount before releasing the button (in ms)",
					required: true				
				)
                
			}
		}
}



def refresh() {
	log "refresh()"
}

def pushButtonMomentary(pin){
    try {
        httpGet(apiUrl + "/device/momentary/" + pin + "/" + delayAmount)		{ resp ->
            if (resp?.data == true)
                log "Pin" + pin + " was set pushed";
            else
                log.error "Pin was not set to 1 then 0";
        }
	} catch (e) { 
        log.error "httpGet call failed ${e}" 
    }
}

def pushButtonOn(pin){
    try {
        httpGet(apiUrl + "/device/on/" + pin)		{ resp ->
            if (resp?.data == true)
                log "Pin" + pin + " was set on";
            else
                log.error "Pin was not set to 1";
        }
	} catch (e) { 
        log.error "httpGet call failed ${e}" 
    }
}

def pushButtonOff(pin){
    try {
        httpGet(apiUrl + "/device/off/" + pin)		{ resp ->
            if (resp?.data == true)
                log "Pin" + pin + " was set off";
            else
                log.error "Pin was not set to 0";
        }
	} catch (e) { 
        log.error "httpGet call failed ${e}" 
    }
}