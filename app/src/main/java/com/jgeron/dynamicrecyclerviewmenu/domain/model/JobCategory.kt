package com.jgeron.dynamicrecyclerviewmenu.domain.model

enum class JobCategory {
    MANAGEMENT, ADMINISTRATION, SERVICE, INTERNAL_WORKER, EXTERNAL_WORKER, UNKNOWN;

    companion object{
        fun fromString(name: String?): JobCategory? =
            values().firstOrNull(){ it.name.uppercase().replace(" ", "_") == name?.uppercase()}
    }
}