package com.aimanissa.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = HabitsRosterEntity.TABLE_NAME)
data class HabitsRosterEntity(

    @PrimaryKey
    @ColumnInfo(name = ROSTER_ID)
    val rosterId: Long,

    @ColumnInfo(name = TITLE)
    val title: String,

    @ColumnInfo(name = DATE)
    val date: Long,

    @ColumnInfo(name = PERCENT_COMPLETE)
    val percentComplete: Int,

    @ColumnInfo(name = IS_SELECTED)
    val isSelected: Boolean
) {

    companion object {

        const val TABLE_NAME = "habits_roster"

        const val ROSTER_ID = "roster_id"
        const val TITLE = "title"
        const val DATE = "date"
        const val PERCENT_COMPLETE = "percent_complete"
        const val IS_SELECTED = "is_selected"
    }
}
