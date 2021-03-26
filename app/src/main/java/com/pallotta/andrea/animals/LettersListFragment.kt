package com.pallotta.andrea.animals

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.ListFragment

class LettersListFragment: ListFragment() {
    val lettersList = arrayListOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    var itemChangedListener: ItemChangedListener? = null

    // interface describing listener for changes to selected item
    interface ItemChangedListener {
        fun onSelectedItemChanged(itemNameString: String)
    }

    fun setCustomItemChangedListener(listener: ItemChangedListener) {
        itemChangedListener = listener
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listAdapter = ItemsArrayAdapter(this.context!!, R.layout.letters_list, lettersList)

        // allow one item to be selected at a time
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        listView.setBackgroundColor(Color.WHITE)
        listView.onItemClickListener = itemOnItemClickListener
    }

    // custom ArrayAdapter
    inner class ItemsArrayAdapter(context: Context, resource: Int, list: ArrayList<String>) :
            ArrayAdapter<String>(context, resource, list) {
        var resource: Int
        var list: ArrayList<String>
        var vi: LayoutInflater

        init {
            this.resource = resource
            this.list = list
            this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val holder: ViewHolder // holds reverence to the current Item's GUI
            var retView: View

            // if convertView is null, infalte GUI and create ViewHolder
            // otherwise, get an existing ViewHolder to reuse
            if (convertView == null) {
                retView = vi.inflate(resource, null)

                // set up ViewHolder
                holder = ViewHolder()
                holder.itemTextView = retView.findViewById<TextView>(R.id.text1)
                retView.tag = holder
            } else {
                // get the ViewHolder using the currentView's tag
                holder = convertView.tag as ViewHolder
                retView = convertView
            }

            val item = list[position] // get current item
            holder.itemTextView?.text = item

            return retView
        }
    }

    // define the GUI component for each list item
    internal class ViewHolder {
        var itemTextView: TextView? = null
    }

    private val itemOnItemClickListener : AdapterView.OnItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->

                itemChangedListener?.onSelectedItemChanged((view as TextView).text.toString())

            }

}