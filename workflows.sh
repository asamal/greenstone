# read the workflow template
WORKFLOW_TEMPLATE=$(cat .github/workflow-template.yml)

# iterate each route in routes directory
for MODULE in $(ls modules); do
    echo "generating workflow for routes/${MODULE}"

    # replace template route placeholder with route name
    WORKFLOW=$(echo "${WORKFLOW_TEMPLATE}" | sed "s/{{MODULE}}/${MODULE}/g")

    # save workflow to .github/workflows/{ROUTE}
    echo "${WORKFLOW}" > .github/workflows/${MODULE}.yml
done