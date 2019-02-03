package com.patapin.djmojo.soundbox.model

import com.patapin.djmojo.soundbox.listener.ClickButton

/**
 * Created by DJMojo on 20/12/2014.
 */
class ButtonInfos(var buttonId: Int, var soundId: Int, var statTextId: Int, var prefCounter: String?) {
    var click: ClickButton? = null
}
