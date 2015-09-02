package com.tusaludsv.model.dao;

public class GenericSql {
	
	public static final String queryTasKManger =  "SELECT tmtask.PK_TM_TASK, tmtask.FK_TM_TASK_DEPEND, tmteam.TEAM_NAME, tmpri.TASK_PRIORITY_DESCRIPTION,"
			+" tmpro.PROJECT_NAME, tmsts.TASK_STATUS_DESCRIPTION, tmown.TASK_OWNER_USERNAME, "
			+" tmtask.TASK_DESCRIPTION, tmtask.SYSTEM_OPERATION, tmtask.ESTIMATED_START_TIME, "
			+" tmtask.ESTIMATED_END_TIME, tmtask.REAL_START_TIME, tmtask.REAL_END_TIME, tmtask.ESTIMATED_TOTAL_TIME,"
			+" tmtask.REAL_TOTAL_TIME, tmtask.ESTIMATED_PERCENT_PROGRESS, tmtask.REAL_PERCENT_PROGRESS, "
			+" Case when tmtask.FK_TM_TASK_DEPEND IS NOT NULL THEN (SELECT tmt.PK_TM_TASK "
			+" FROM TM_TASK tmt JOIN TM_TASK_STATUS tmstss ON tmstss.PK_TM_TASK_STATUS = tmt.FK_TM_TASK_STATUS where tmt.PK_TM_TASK =tmtask.FK_TM_TASK_DEPEND) "
			+" else null end idDependt FROM TM_TASK tmtask JOIN TM_TEAM tmteam ON tmteam.PK_TM_TEAM = tmtask.FK_TM_TEAM "
			+" JOIN TM_TASK_PRIORITY tmpri ON tmpri.PK_TM_TASK_PRIORITY   = tmtask.FK_TM_TASK_PRIORITY "
			+" JOIN TM_PROJECT tmpro ON tmpro.PK_TM_PROJECT   = tmtask.FK_TM_PROJECT "
			+" JOIN TM_TASK_STATUS tmsts ON tmsts.PK_TM_TASK_STATUS   = tmtask.FK_TM_TASK_STATUS "
			+" JOIN TM_TASK_OWNER tmown ON tmown.PK_TM_TASK_OWNER   = tmtask.FK_TM_TASK_OWNER ";
	
	public static final String queryStatus = "SELECT PK_TM_TASK_STATUS, TASK_STATUS_DESCRIPTION from TM_TASK_STATUS";

}
