-- INSERT DATA IN ROLES, PERMISSIONS AND ROLE_PERMISSIONS USING CTE
WITH
-- 1. Insert new roles and return their IDs
new_roles AS (
	INSERT INTO roles (rol_name)
	VALUES
		('admin'),
		('user'),
		('employee')
	RETURNING id, rol_name
),
-- 2. Insert new permissions and their IDs
new_permissions AS (
	INSERT INTO permissions (name_permission)
	VALUES
		('admin:read'),
		('admin:write'),
		('admin:delete'),
		('user:write'),
		('user:read'),
		('user:delete'),
		('employee:read'),
		('employee:write')
	RETURNING id, name_permission
)
-- 3. Insert in roles_permission
INSERT INTO roles_permissions (rol_id, permission_id)
SELECT r.id, p.id
FROM new_roles r, new_permissions p
WHERE (r.rol_name = 'admin' AND p.name_permission IN ('admin:read', 'admin:write', 'admin:delete'))
OR (r.rol_name = 'user' AND p.name_permission IN ('user:read', 'user:write', 'user:delete'))
OR (r.rol_name = 'employee' AND p.name_permission IN ('employee:read', 'employee:write'));
