package mx.edu.ittepic.prueba_1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.view.Gravity
import android.widget.Toast

class Llamadas : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_RINGING){
            showToast(context,"Llamada Entrante...")
        }else if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_OFFHOOK){
            showToast(context,"Llamada Contestada")
        }else if(intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_IDLE){
            showToast(context,"Llamada Terminada")
        }
    }

    fun showToast(context: Context?,message: String){
        var toast = Toast.makeText(context,message,Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }
}