package pl.edu.pjatk.pro1

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.coroutines.NonCancellable.start


class ConfirmDialogFragment(val Todotask: ToDoTask, val adapter: TasksAdapter) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Do you want to delete this task?")
                .setPositiveButton("Yes"
                ) { dialog, id ->
                    DataSource.tasks.remove(Todotask)
                    adapter.replace(DataSource.tasks)
                }
                .setNegativeButton("No"
                ) { dialog, id ->
                    // User cancelled the dialog
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}